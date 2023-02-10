package com.prjfoody.foody.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBasket is a Querydsl query type for Basket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasket extends EntityPathBase<Basket> {

    private static final long serialVersionUID = -2060976497L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBasket basket = new QBasket("basket");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProduct product;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final QUsers user;

    public QBasket(String variable) {
        this(Basket.class, forVariable(variable), INITS);
    }

    public QBasket(Path<? extends Basket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBasket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBasket(PathMetadata metadata, PathInits inits) {
        this(Basket.class, metadata, inits);
    }

    public QBasket(Class<? extends Basket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

