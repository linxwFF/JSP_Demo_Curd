package com.pojo;

import java.util.Date;

/**
 * Created by LINxwFF on 2017/11/21.
 */
//id uuid name ts(型号规格) quantity(数量) date_of_manufacture(生产日期) shelf_life(保质期) vendor（生产厂家） supplier(供应商)
public class Product {

    private int id;
    private int uuid;
    private String name;
    private String ts;
    private int quantity;
    private Date date_of_manufacture;
    private int shelf_life;
    private String vendor;
    private String supplier;

    public Product() {
    }

    public Product(int id, int uuid, String name, String ts, int quantity, Date date_of_manufacture, int shelf_life, String vendor, String supplier) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.ts = ts;
        this.quantity = quantity;
        this.date_of_manufacture = date_of_manufacture;
        this.shelf_life = shelf_life;
        this.vendor = vendor;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate_of_manufacture() {
        return date_of_manufacture;
    }

    public void setDate_of_manufacture(Date date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    public int getShelf_life() {
        return shelf_life;
    }

    public void setShelf_life(int shelf_life) {
        this.shelf_life = shelf_life;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
