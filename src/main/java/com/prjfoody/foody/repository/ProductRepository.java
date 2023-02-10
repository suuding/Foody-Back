package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.QProduct;
import com.prjfoody.foody.domain.Users;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Qualifier("ProductRepository")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProductRepository implements Repositories<Product> {

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory q;

    @Override
    public List<Product> select(Product product, Users user) {
        QProduct qProduct = QProduct.product;
        BooleanBuilder builder = new BooleanBuilder();

        if (product.getTitle() != null)
            builder.and(qProduct.title.eq(product.getTitle()));

        if (product.getId() != null)
            builder.and(qProduct.id.eq(product.getId()));

        if (product.getCategory() != null)
            builder.and(qProduct.category.eq(product.getCategory()));

        if (product.getLock() != null)
            builder.and(qProduct.lock.eq(product.getLock()));

        if (product.getOwner() != null)
            builder.and(qProduct.owner.eq(product.getOwner()));

        return q.selectFrom(qProduct)
                .where(builder)
                .fetch();
    }

    @Override
    public Boolean create(Product product, Users user) {
        log.info("product.getTitle() = " + product.getTitle());
        log.info("product.getDescription() = " + product.getDescription());
        try{
            em.persist(product);
            log.info("create product suc " + product.getTitle());

            return true;
        }catch (Exception e){
            log.warn("create product fail " + product.getTitle());

            return false;
        }

    }

    @Override
    public Boolean update(Product product, Users user) {
        QProduct qProduct = QProduct.product;

        try {
            q.update(qProduct)
                    .set(qProduct.lastDateTime, product.getLastDateTime())
                    .set(qProduct.title , product.getTitle())
                    .set(qProduct.description , product.getDescription())

                    /* 여기서부터 set 값에대해 어느정도 검증이 필요함 */
                    .set(qProduct.delete , product.getDelete())
                    .set(qProduct.lock , product.getLock())
                    .set(qProduct.category , product.getCategory())
                    .set(qProduct.grade , product.getPrice())
                    .set(qProduct.price , product.getPrice())
                    .set(qProduct.quantity , product.getQuantity())
                    .set(qProduct.salePrice , product.getPrice())
                    .set(qProduct.saleRate , product.getSaleRate())
                    .set(qProduct.saleStatus , product.getSaleStatus())
                    .set(qProduct.productImageUrl , product.getProductImageUrl())

                    .where(qProduct.id.eq(product.getId()))
                    .execute();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id, Users user) {
        QProduct qProduct = QProduct.product;
        try {
            q.delete(qProduct)
                    .where(qProduct.id.eq(id))
                    .execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
