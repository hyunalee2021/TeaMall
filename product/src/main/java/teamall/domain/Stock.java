package teamall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import teamall.ProductApplication;
import teamall.domain.StockDecreased;

@Entity
@Table(name = "Stock_table")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String stock;

    @PostPersist
    public void onPostPersist() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();
    }

    public static StockRepository repository() {
        StockRepository stockRepository = ProductApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    public static void stockDecrease(DeliverCompleted deliverCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliverCompleted.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }
}
