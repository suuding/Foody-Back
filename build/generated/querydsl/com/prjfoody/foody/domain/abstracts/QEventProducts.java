package com.prjfoody.foody.domain.abstracts;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventProducts is a Querydsl query type for EventProducts
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QEventProducts extends EntityPathBase<EventProducts> {

    private static final long serialVersionUID = 2027227608L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventProducts eventProducts = new QEventProducts("eventProducts");

    public final QProducts _super;

    //inherited
    public final EnumPath<com.prjfoody.foody.domain.types.Category> category;

    //inherited
    public final BooleanPath delete;

    //inherited
    public final StringPath description;

    public final NumberPath<Long> eventId = createNumber("eventId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstDateTime;

    //inherited
    public final NumberPath<Integer> grade;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastDateTime;

    //inherited
    public final BooleanPath lock;

    // inherited
    public final com.prjfoody.foody.domain.QUsers owner;

    //inherited
    public final NumberPath<Integer> price;

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

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

    public QEventProducts(String variable) {
        this(EventProducts.class, forVariable(variable), INITS);
    }

    public QEventProducts(Path<? extends EventProducts> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventProducts(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventProducts(PathMetadata metadata, PathInits inits) {
        this(EventProducts.class, metadata, inits);
    }

    public QEventProducts(Class<? extends EventProducts> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QProducts(type, metadata, inits);
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

