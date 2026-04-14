package org.projekt2_gruppe_2.Wishlist;

import org.springframework.stereotype.Repository;

@Repository
public class WishlistRepository {

    public Wishlist findById(int id){
        Wishlist w = new Wishlist();
        w.setId(id);
        w.setName("Test ønskeseddle");
        w.setUserId(1);
        return w;
    }


}
