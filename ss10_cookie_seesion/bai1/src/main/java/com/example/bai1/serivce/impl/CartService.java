package com.example.bai1.serivce.impl;

import com.example.bai1.model.Cart;
import com.example.bai1.serivce.ICartService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class CartService implements ICartService {
//    giỏ hàng
   Map<Integer,Cart>cartMap=new HashMap<>();
   @Override
   public void add(Cart cart){
       boolean check=false;
       for( Map.Entry< Integer,Cart> entry :cartMap.entrySet()){
           if (entry.getValue().getId().equals(cart.getId())){
               entry.getValue().setQuantity(entry.getValue().getQuantity()+1);
               check=true;
               break;
           }
       }
       if (check==false){
           cartMap.put(cart.getId(),cart);
       }

   }
   @Override
   public void delete(Integer id){
       cartMap.remove(id);
   }
    @Override
   public Cart update(Integer idProduct, Integer quantity){
       Cart cart=cartMap.get(idProduct);
       cart.setQuantity(quantity);
        return cart;
   }

    @Override
    public void clear(){
       cartMap.clear();
    }
    @Override
    public Collection<Cart> getAll(){
       return cartMap.values();
    }
    @Override
    public Integer getCount(){
       return cartMap.values().size();
    }
    @Override
    public double getAmount(){
       return cartMap.values().stream().mapToDouble(entry->entry.getQuantity() * entry.getPrice()).sum();
    }

}
