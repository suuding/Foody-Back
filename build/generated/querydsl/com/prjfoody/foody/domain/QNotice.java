package com.prjfoody.foody.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNotice is a Querydsl query type for Notice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotice extends EntityPathBase<Notice> {

    private static final long serialVersionUID = -1704469599L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNotice notice = new QNotice("notice");

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

    // inherited
    public final QUsers owner;

    //inherited
    public final StringPath title;

    //inherited
    public final NumberPath<Integer> viewCount;

    public QNotice(String variable) {
        this(Notice.class, forVariable(variable), INITS);
    }

    public QNotice(Path<? extends Notice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNotice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNotice(PathMetadata metadata, PathInits inits) {
        this(Notice.class, metadata, inits);
    }

    public QNotice(Class<? extends Notice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.prjfoody.foody.domain.abstracts.QNoticeAndMtm(type, metadata, inits);
        this.delete = _super.delete;
        this.description = _super.description;
        this.firstDateTime = _super.firstDateTime;
        this.lastDateTime = _super.lastDateTime;
        this.lock = _super.lock;
        this.owner = _super.owner;
        this.title = _super.title;
        this.viewCount = _super.viewCount;
    }

}

