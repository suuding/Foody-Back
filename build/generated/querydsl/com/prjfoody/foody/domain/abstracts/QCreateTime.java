package com.prjfoody.foody.domain.abstracts;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCreateTime is a Querydsl query type for CreateTime
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QCreateTime extends EntityPathBase<CreateTime> {

    private static final long serialVersionUID = -1112074129L;

    public static final QCreateTime createTime = new QCreateTime("createTime");

    public final DateTimePath<java.time.LocalDateTime> firstDateTime = createDateTime("firstDateTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> lastDateTime = createDateTime("lastDateTime", java.time.LocalDateTime.class);

    public QCreateTime(String variable) {
        super(CreateTime.class, forVariable(variable));
    }

    public QCreateTime(Path<? extends CreateTime> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCreateTime(PathMetadata metadata) {
        super(CreateTime.class, metadata);
    }

}

