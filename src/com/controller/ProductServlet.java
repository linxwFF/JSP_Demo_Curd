package com.controller;

import com.pojo.Product;
import com.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by LINxwFF on 2017/11/21.
 */
@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("add")){
            Add(request,response);
            return;
        }
        if(method.equals("update")){
            Update(request,response);
            return;
        }
        if(method.equals("query")){
            query(request,response);
            return;
        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("input");

        ArrayList<Product> list = productService.query(input);
        if(list.size() > 0){
            request.setAttribute("queryList",list);
        }

        request.getRequestDispatcher("/query.jsp").forward(request,response);
    }

    //添加商品
    private void Add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setUuid(Integer.parseInt(request.getParameter("uuid")));
        product.setName(request.getParameter("name"));
        product.setTs(request.getParameter("ts"));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setDate_of_manufacture(null);
        product.setShelf_life(Integer.parseInt(request.getParameter("shelf_life")));
        product.setVendor(request.getParameter("vendor"));
        product.setSupplier(request.getParameter("supplier"));

        if(productService.add(product)){
            request.setAttribute("msg","添加商品成功");
            response.sendRedirect("/product");
        }else {
            request.setAttribute("msg","添加商品失败");
            response.sendRedirect("/product");
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product = new Product();
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setUuid(Integer.parseInt(request.getParameter("uuid")));
        product.setName(request.getParameter("name"));
        product.setTs(request.getParameter("ts"));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setDate_of_manufacture(null);
        product.setShelf_life(Integer.parseInt(request.getParameter("shelf_life")));
        product.setVendor(request.getParameter("vendor"));
        product.setSupplier(request.getParameter("supplier"));

        if(productService.update(product)){
            request.setAttribute("msg","更新商品成功");
            response.sendRedirect("product?method=list");
        }else {
            request.setAttribute("msg","更新商品失败");
            response.sendRedirect("product?method=list");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method == null || method.equals("")){
            //获取列表
            ArrayList<Product> list = productService.getList();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        if(method.equals("modify")){
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productService.getUserByID(id);
            request.setAttribute("product",product);
            request.getRequestDispatcher("/modify.jsp").forward(request,response);
            return;
        }else if(method.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));

            if(productService.delete(id)){
                request.setAttribute("msg","删除商品成功");
                response.sendRedirect("product?method=list");
            }else {
                request.setAttribute("msg","删除商品失败");
                response.sendRedirect("product?method=list");
            }
            return;
        }else if(method.equals("query")){
            request.getRequestDispatcher("/query.jsp").forward(request,response);
            return;
        }

        //获取列表
        ArrayList<Product> list = productService.getList();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return;
    }
}
