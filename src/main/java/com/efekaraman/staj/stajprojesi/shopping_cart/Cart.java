package com.efekaraman.staj.stajprojesi.shopping_cart;

import com.efekaraman.staj.stajprojesi.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document("cart")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cart {

    @Id
    private String id;

    @Field("item_count")
    private int itemCount;

    @Field("customer_id")
    @NotNull
    private String customerId;

    @Field("product_list")
    private List<Product> productList;

}
