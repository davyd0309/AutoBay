package pl.witkowski.AutoBay.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    Auction findAuctionById(Long id);
}
