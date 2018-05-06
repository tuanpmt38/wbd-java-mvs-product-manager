package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                creatProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
//                searchProduct(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                viewProduct(request, response);
                break;
            case "delete":
                showDeleteProduct(request,response);
                break;
            case "edit":
                showEditProduct(request, response);
            case "create":
                showCreatProduct(request, response);
                break;
            case "search":
//                showResultResoult(request,response);
                searchProduct(request, response);
            default:
                listProduct(request, response);
                break;
        }
    }

    //detail
    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = this.productService.findById(id);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //delete
    private void showDeleteProduct (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        request.setAttribute("product",product);
        dispatcher.forward(request,response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = this.productService.findById(id);
        request.setAttribute("products", products);
        if (products != null) {
            this.productService.remove(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/products");
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //update
    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (products == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("products", products);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String discription = request.getParameter("discription");
        String produrce = request.getParameter("produrce");
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDesription(discription);
            product.setProducer(produrce);
            this.productService.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create
    private void showCreatProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String discription = request.getParameter("discription");
        String produrce = request.getParameter("produrce");
        int id = (int) (Math.random() * 100);

        Product product = new Product(id, name, price, discription, produrce);
        this.productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // private void showResultResoult(HttpServletRequest request, HttpServletResponse response){
//        String name = request.getParameter("key");
//        Product product = (Product) this.productService.findByName(name);
//        RequestDispatcher dispatcher ;
//
//        if(product == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            request.setAttribute("product", product);
//            dispatcher = request.getRequestDispatcher("product/search.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    //   }
    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/search.jsp");
//
//        String name = request.getParameter("key");
//        Product product = (Product) this.productService.findByName(name);
//
//        request.setAttribute("product",product);
//        dispatcher.forward(request,response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        String name = request.getParameter("key");
        request.setAttribute("product", productService.findByName(name));
        dispatcher.forward(request, response);

    }

}
