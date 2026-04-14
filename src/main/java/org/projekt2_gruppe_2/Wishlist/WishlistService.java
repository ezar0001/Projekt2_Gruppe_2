package org.projekt2_gruppe_2.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist getWishlistById(int id){
        return wishlistRepository.findById(id);
    }
}

