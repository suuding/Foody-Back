package com.prjfoody.foody.domain.abstracts;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNoticeAndMtm is a Querydsl query type for NoticeAndMtm
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QNoticeAndMtm extends EntityPathBase<NoticeAndMtm> {

    private static final long serialVersionUID = -1365649331L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNoticeAndMtm noticeAndMtm = new QNoticeAndMtm("noticeAndMtm");

    public final QStuff _super;

    //inherited
    public final BooleanPath delete;

    //inherited
    public final StringPath description;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstDateTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastDateTime;

    //inherited
    public final BooleanPath lock;

    // inherited
    public final com.prjfoody.foody.domain.QUsers owner;

    //inherited
    public final StringPath title;

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QNoticeAndMtm(String variable) {
        this(NoticeAndMtm.class, forVariable(variable), INITS);
    }

    public QNoticeAndMtm(Path<? extends NoticeAndMtm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNoticeAndMtm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNoticeAndMtm(PathMetadata metadata, PathInits inits) {
        this(NoticeAndMtm.class, metadata, inits);
    }

    public QNoticeAndMtm(Class<? extends NoticeAndMtm> type, PathMetadata metadata, PathInits inits) {
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

