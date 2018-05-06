package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Product> list;
    static {
        list= new HashMap<>();
        list.put(1,new Product(1,"tivi",800,"tcl","toshiba"));
        list.put(2,new Product(2,"dream",8200,"run","honda"));
        list.put(3,new Product(3,"telephone",1000,"new model","apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(list.values());
    }

    @Override
    public Product findById(int id) {
        return list.get(id);
    }

    @Override
    public void remove (int id){
        list.remove(id);
    }

    @Override
    public void update (int id, Product product){
        list.put(id,product);
    }

    @Override
    public void save(Product product) {
        list.put(product.getId(),product);
    }
    @Override
    public List<Product> findByName(String name){
        List<Product> listproduct = new ArrayList<>();
        for(Product product : list.values()){
            if(product.getName().contains(name)){
                listproduct.add(listproduct.get(product.getId()));
            }
        }
        return listproduct;
    }
}
