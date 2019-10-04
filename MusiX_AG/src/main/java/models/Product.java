package models;

import javax.persistence.*;


@Entity
@Table (name = "product")
public class Product {
    @Id
    private  int Id;
//    @Column(name = "title")
    private String title;
    private String price;

    public Product(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    public Product(int id, String title, String price) {
        Id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "models.Product{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
