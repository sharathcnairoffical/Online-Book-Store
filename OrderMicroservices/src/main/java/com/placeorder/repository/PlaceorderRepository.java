package com.placeorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.placeorder.model.Placeorder;

@Repository
public interface PlaceorderRepository extends JpaRepository<Placeorder, Long>{


	@Query("Select o from Placeorder o where o.userid=?1 and o.book_id=?2")
	public Placeorder exists(String userId, int bookId);
	
	@Query(value="from Placeorder o where o.userid=?1")
	public List<Placeorder> findByUserId(String userId);
}
