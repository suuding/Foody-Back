package com.prjfoody.foody.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMtmReply is a Querydsl query type for MtmReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMtmReply extends EntityPathBase<MtmReply> {

    private static final long serialVersionUID = 860391789L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMtmReply mtmReply = new QMtmReply("mtmReply");

    public final com.prjfoody.foody.domain.abstracts.QNoticeAndMtm _super;

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

    public final QMtm mtm;

    // inherited
    public final QUsers owner;

    //inherited
    public final StringPath title;

    //inherited
    public final NumberPath<Integer> viewCount;

    public QMtmReply(String variable) {
        this(MtmReply.class, forVariable(variable), INITS);
    }

    public QMtmReply(Path<? extends MtmReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMtmReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMtmReply(PathMetadata metadata, PathInits inits) {
        this(MtmReply.class, metadata, inits);
    }

    public QMtmReply(Class<? extends MtmReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.prjfoody.foody.domain.abstracts.QNoticeAndMtm(type, metadata, inits);
        this.delete = _super.delete;
        this.description = _super.description;
        this.firstDateTime = _super.firstDateTime;
        this.lastDateTime = _super.lastDateTime;
        this.lock = _super.lock;
        this.mtm = inits.isInitialized("mtm") ? new QMtm(forProperty("mtm"), inits.get("mtm")) : null;
        this.owner = _super.owner;
        this.title = _super.title;
        this.viewCount = _super.viewCount;
    }

}

