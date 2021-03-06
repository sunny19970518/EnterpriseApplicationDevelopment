/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import entities.Item;
import entityControl.ItemFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "crudBean")
@SessionScoped
public class CrudBean implements Serializable {
    
    @EJB
    private ItemFacade itemFacade;
    
    /**
     * Creates a new instance of CrudBean
     */
    public CrudBean() {
    }
    
    private Item newItem;
    
    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }

    private Item updateItem;
    
    public Item getUpdateItem() {
        return updateItem;
    }

    public void setUpdateItem(Item updateItem) {
        this.updateItem = updateItem;
    }
    
    private Long itemID;

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;        
    }

    public List<Item> findAll(){
        return itemFacade.findAll();
    }
    
    public String goNewItemPage(){
        this.newItem = new Item();
        return "createItem";
    }
    
    public String addItem(){
        itemFacade.create(newItem);
        return "itemList";
    }
    
    public String delect(Item item){
        itemFacade.remove(item);
        return "itemList";
    }
    
    public String goUpdateItemPage(){
        System.out.println("updateItem");
        this.updateItem = itemFacade.find(itemID);
        return "updateItem";
    }
    
    public Item find(){
        return itemFacade.find(itemID);
    }
 
    public String update(){
       Item editItem = getUpdateItem();
       itemFacade.edit(editItem);
       return "itemList";
    }
    
}
