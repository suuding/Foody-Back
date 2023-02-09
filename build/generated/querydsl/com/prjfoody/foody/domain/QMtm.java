package com.prjfoody.foody.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMtm is a Querydsl query type for Mtm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMtm extends EntityPathBase<Mtm> {

    private static final long serialVersionUID = 783794045L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMtm mtm = new QMtm("mtm");

    public final com.prjfoody.foody.domain.abstracts.QNoticeAndMtm _super;

    public final StringPath content = createString("content");

    //inherited
    public final BooleanPath delete;

    //inherited
    public final StringPath description;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstDateTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastDateTime;

    //inherited
    public final BooleanPath lock;

    // inherited
    public final QUsers owner;

    public final BooleanPath status = createBoolean("status");

    public final StringPath title = createString("title");

    //inherited
    public final NumberPath<Integer> viewCount;

    public final StringPath writer = createString("writer");

    public QMtm(String variable) {
        this(Mtm.class, forVariable(variable), INITS);
    }

    public QMtm(Path<? extends Mtm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMtm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMtm(PathMetadata metadata, PathInits inits) {
        this(Mtm.class, metadata, inits);
    }

    public QMtm(Class<? extends Mtm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.prjfoody.foody.domain.abstracts.QNoticeAndMtm(type, metadata, inits);
        this.delete = _super.delete;
        this.description = _super.description;
        this.firstDateTime = _super.firstDateTime;
        this.lastDateTime = _super.lastDateTime;
        this.lock = _super.lock;
        this.owner = _super.owner;
        this.viewCount = _super.viewCount;
    }

}

