package com.prjfoody.foody.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 557195590L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final com.prjfoody.foody.domain.abstracts.QProducts _super;

    //inherited
    public final EnumPath<com.prjfoody.foody.domain.types.Category> category;

    //inherited
    public final BooleanPath delete;

    //inherited
    public final StringPath description;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstDateTime;

    //inherited
    public final NumberPath<Integer> grade;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastDateTime;

    //inherited
    public final BooleanPath lock;

    // inherited
    public final QUsers owner;

    //inherited
    public final NumberPath<Integer> price;

    public final StringPath productImageUrl = createString("productImageUrl");

    //inherited
    public final NumberPath<Integer> quantity;

    //inherited
    public final NumberPath<Integer> salePrice;

    //inherited
    public final NumberPath<Float> saleRate;

    //inherited
    public final BooleanPath saleStatus;

    //inherited
    public final StringPath title;

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.prjfoody.foody.domain.abstracts.QProducts(type, metadata, inits);
        this.category = _super.category;
        this.delete = _super.delete;
        this.description = _super.description;
        this.firstDateTime = _super.firstDateTime;
        this.grade = _super.grade;
        this.lastDateTime = _super.lastDateTime;
        this.lock = _super.lock;
        this.owner = _super.owner;
        this.price = _super.price;
        this.quantity = _super.quantity;
        this.salePrice = _super.salePrice;
        this.saleRate = _super.saleRate;
        this.saleStatus = _super.saleStatus;
        this.title = _super.title;
    }

}

