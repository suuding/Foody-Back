package com.prjfoody.foody.domain.abstracts;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProducts is a Querydsl query type for Products
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QProducts extends EntityPathBase<Products> {

    private static final long serialVersionUID = -461092502L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProducts products = new QProducts("products");

    public final QStuff _super;

    public final EnumPath<com.prjfoody.foody.domain.types.Category> category = createEnum("category", com.prjfoody.foody.domain.types.Category.class);

    //inherited
    public final BooleanPath delete;

    //inherited
    public final StringPath description;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstDateTime;

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastDateTime;

    //inherited
    public final BooleanPath lock;

    // inherited
    public final com.prjfoody.foody.domain.QUsers owner;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<Integer> salePrice = createNumber("salePrice", Integer.class);

    public final NumberPath<Float> saleRate = createNumber("saleRate", Float.class);

    public final BooleanPath saleStatus = createBoolean("saleStatus");

    //inherited
    public final StringPath title;

    public QProducts(String variable) {
        this(Products.class, forVariable(variable), INITS);
    }

    public QProducts(Path<? extends Products> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProducts(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProducts(PathMetadata metadata, PathInits inits) {
        this(Products.class, metadata, inits);
    }

    public QProducts(Class<? extends Products> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QStuff(type, metadata, inits);
        this.delete = _super.delete;
        this.description = _super.description;
        this.firstDateTime = _super.firstDateTime;
        this.lastDateTime = _super.lastDateTime;
        this.lock = _super.lock;
        this.owner = _super.owner;
        this.title = _super.title;
    }

}

