package com.cognizant.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.cognizant.bean.AuthenticationRequest;
import com.cognizant.bean.Book;
import com.cognizant.bean.LoginModel;
import com.cognizant.bean.Placeorder;
import com.cognizant.dto.AuthenticationResponseDTO;
import com.cognizant.dto.PlaceOrderRequestDto;
import com.cognizant.dto.PlaceOrderResponseDto;
import com.cognizant.exception.CustomerNotFoundException;
import com.cognizant.proxy.AuthProxy;
import com.cognizant.proxy.BookFeignClient;
import com.cognizant.proxy.OrderFeignClient;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MvcController {
	HttpSession session;
	
	@Autowired
	private AuthProxy authFeign;
	
	@Autowired
	private BookFeignClient bookFeign;
	
	@Autowired
	private OrderFeignClient orderFeign;
	
	static AuthenticationResponseDTO token = null;
	static String jwt=null;
	static String userName;
	static String myRole;
	
	
	@GetMapping("/error")
	public String error()
	{
		return "ERROR";
	}
//----------------------------------------------------------------------------------------------------------------------------------------------	
	@GetMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("model", new LoginModel());
		return mv;
	}

	@PostMapping("/login")
	public ModelAndView performLogin(@Valid @ModelAttribute("model") LoginModel model, BindingResult result,
			HttpServletRequest request, HttpSession session) throws FeignException {
		ModelAndView mv = new ModelAndView("login");
		System.out.println(result);

		log.info(" Before Token generation");

		try {
			token = authFeign.login(model);
		} catch (Exception e) {
			log.info("Exception");
			mv.addObject("error", "Invalid Credentials");
			return mv;
		}
		request.getSession().setAttribute("token", "Bearer " + token.getJwtAuthToken());
		request.getSession().setAttribute("user", model.getUserName());

		log.info(" After Token generation");
		log.info(model.getUserName());
		log.info("Check role in LoginController: " + authFeign.getRole(model.getUserName()));
		log.info(token.getJwtAuthToken());
		AuthenticationRequest authenticationrequest = authFeign.getRole(model.getUserName());
		session.setAttribute("token", token.getJwtAuthToken());
		jwt =token.getJwtAuthToken();
		log.debug("session{}:", session.toString());
		userName = model.getUserName();
		//getRole
		myRole=authenticationrequest.getRole();
		log.info(myRole);
		if (authenticationrequest.getRole().equals("admin") && token != null) {
			log.info("Dsiplaying Admin Page");
			return new ModelAndView(new RedirectView("/"));
		} else if (!authenticationrequest.getRole().equals("admin")&&token != null) {
			log.info("Dsiplaying User Page");
			return new ModelAndView(new RedirectView("cust"));
		} else {
			return new ModelAndView(new RedirectView("forbidden"));

		}
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("token", null);
		session.setAttribute("token", "");
		token = null;
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("model", new LoginModel());
		return mv;
	}
	/*---------------------------------------------------Business Logic Implementation-----------------------------------------------*/

	
	@GetMapping("/")
	public ModelAndView getHomePage(Model model, HttpServletRequest session) {
		if (token != null && myRole.equalsIgnoreCase("admin")) {
		//String name = (String) session.getSession().getAttribute("name");
		List<Book> allBooks = bookFeign.getAllBooks();
		model.addAttribute("allBooks", allBooks);
		//model.addAttribute("name", name);
		return new ModelAndView("home");
		}else {
			return new ModelAndView("forbidden");
		}
	}
	@GetMapping("/cust")
	public ModelAndView getHomePageForCust(Model model, HttpServletRequest session) {
		if (token != null && !myRole.equalsIgnoreCase("admin")) {
		//String name = (String) session.getSession().getAttribute("name");
		List<Book> allBooks = bookFeign.getAllBooks();
		model.addAttribute("allBooks", allBooks);
		//model.addAttribute("name", name);
		return new ModelAndView("customerhome");
		}
		else {
			return new ModelAndView("forbidden");
		}
	}
	
	@GetMapping("/search")
	public String getProduct(@RequestParam("book_title") @Valid String name, Model model) {

		List<Book> bookList = new ArrayList<>();
		try {

			bookList = bookFeign.searchBookByname(name);	
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		model.addAttribute("bookList", bookList);
		return "book";
		
	}
	
	
	//---------------------------------------------------------------------------------
	@GetMapping("/addBookItems")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	@PostMapping("/addBookDataItems")
	public String addBookData(@ModelAttribute Book book) {
		book.setCreated_By(userName);
		book.setCreatedBy(userName);
		bookFeign.addBook(book);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteBook(@RequestParam int id) {
		bookFeign.deleteBook(id);
		return "redirect:/";
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView toEditBook(@RequestParam int id, @RequestParam String title, @RequestParam long price, @RequestParam String author,
			@RequestParam(name = "summary",required=false) String summary,@RequestParam String image,@RequestParam String category, @RequestParam int stockcount, ModelMap model) throws Exception {
		model.addAttribute("editBook", new Book());
		log.info("{}",id);
		model.addAttribute("book_id", id);
		model.addAttribute("book_title",title);
		model.addAttribute("price",price);
		model.addAttribute("book_image",image);
		model.addAttribute("modify_Date", LocalDate.now());
		model.addAttribute("modifyDate", LocalDate.now());
		model.addAttribute("modify_By",userName);
		model.addAttribute("modifyBy",userName);
		model.addAttribute("author",author);
		model.addAttribute("summary", summary);
		model.addAttribute("category", category);
		model.addAttribute("stockcount", stockcount);
//		if (token == null) 
		
		if (jwt != null){
			log.info("Hello");
			ModelAndView mv = new ModelAndView("edit-book-item");
			mv.addObject("model", new LoginModel());
			return mv;
		} else {
			return new ModelAndView("forbidden");
		}
	}
	
	@RequestMapping(value = "/edit-book-item-success", method = RequestMethod.POST)
	public ModelAndView successEditBook(@ModelAttribute("editBook") Book book, ModelMap model) {
		bookFeign.updateBook(book);
		List<Book> list= bookFeign.getAllBooks();

		model.put("inf", list);
		if (jwt != null) {
			ModelAndView mv = new ModelAndView("edit-book-item-success");
			mv.addObject("model", new LoginModel());
			return mv;
		} else {
			return new ModelAndView("forbidden");
		}
	}
	
//	@GetMapping("/order-list")
//	public ModelAndView getAllMovies(ModelMap map) {
//		List<Placeorder>orders = orderFeign.getOrderDetailsAdmin();
//		map.put("inf", orders);
//		if (jwt != null && myRole.equalsIgnoreCase("admin")) {
//			ModelAndView mv = new ModelAndView("order-details-admin");
//			mv.addObject("model", new LoginModel());
//			return mv;
//		} else {
//			return new ModelAndView("forbidden");
//		}

//	}
//	@GetMapping("/view-order")
//	public String getorderadmin(HttpSession httpSession, Model model) {
//		
//		//String token = "Bearer " + (String) httpSession.getAttribute("jwt");
//		String user = (String) httpSession.getAttribute("admin");
//		List<Placeorder>orders = orderFeign.getOrderDetailsAdmin();
//		model.addAttribute("inf", orders);
//		model.addAttribute("order", new Placeorder());
//		log.info("inside MVC controller -> view adminorders");
//		return "adminorder";
//		
//	}
	
	/*---------------------------------------------------Place Order--------------------------------------------------------------------------*/
	

	@GetMapping("/add-to-cart")
	public String getProductPage(@RequestParam int id, Model model, HttpServletRequest httpServletRequest,
			@ModelAttribute("placeOrderRequestDto") PlaceOrderRequestDto placeOrderRequestDto) {
		Book book = bookFeign.getBookById(id);
		model.addAttribute("book", book);
		model.addAttribute("name", httpServletRequest.getSession().getAttribute("user"));
		return "add-to-cart";

	}

	@PostMapping("/add")
	public String String(@ModelAttribute("placeOrderRequestDto") PlaceOrderRequestDto placeOrderRequestDto, HttpServletRequest request,
			Model model) {

		//String token = "Bearer " + (String) request.getSession().getAttribute("jwt");
		String user = (String) request.getSession().getAttribute("user");

		if (user == null)
			return "redirect:/login";
		placeOrderRequestDto.setUser_id(user);
		//String response = orderFeign.placeOrder(jwt, placeOrderRequestDto);
		String response = orderFeign.placeOrder(jwt,placeOrderRequestDto);
		if (response.equals("Successfully added to Cart"))
			return "redirect:/";

		model.addAttribute("outOfStock", response);
		model.addAttribute("book", bookFeign.getBookById(placeOrderRequestDto.getBook_id()));

		return "add-to-cart";
	}

	@GetMapping("/view-cart")
	public String getCart(HttpSession httpSession, Model model) {
		
		//String token = "Bearer " + (String) httpSession.getAttribute("jwt");
		String user = (String) httpSession.getAttribute("user");
		List<PlaceOrderResponseDto> cartList = orderFeign.viewOrder(user);
		model.addAttribute("cartList", cartList);
		model.addAttribute("order", new Placeorder());
		return "cart";
		
	}
	
	@GetMapping("/orderdelete")
	public String deleteFromCart(@RequestParam int id, HttpServletRequest request) {
		//String token = "Bearer " + (String) request.getSession().getAttribute("jwt");
		String user = (String) request.getSession().getAttribute("user");
		orderFeign.deleteFromOrder( user, id);
		return "redirect:/view-cart";

	}
	
	@GetMapping("/checkout")
	public String checkout(HttpSession httpSession, Model model) {
//
//		String token = "Bearer " + (String) httpSession.getAttribute("jwt");
//		String email = (String) httpSession.getAttribute("email");
//
//		List<CartResponseDto> cartList = cartProxy.getCart(token, email);
//		
//		model.addAttribute("cartList", cartList);
//		model.addAttribute("product", new Product());

		return "checkout";
		
	}
	
	
	
	
	
}
