package repository;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepo {
    @Autowired
    EntityManager entityManager;
    @Autowired
    ProductService productRepo;

    public List<Product> getList() {
        String queryStr = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        List<Product> list = query.getResultList();
        return list;
    }

    public void save(Product product) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(product);
        txn.commit();
        entityManager.persist(product);
        List list = productRepo.getAll();
        System.out.println(list.size());
    }
}
