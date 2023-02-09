package com.prjfoody.foody.domain.abstracts;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStuff is a Querydsl query type for Stuff
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QStuff extends EntityPathBase<Stuff> {

    private static final long serialVersionUID = -1610153042L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStuff stuff = new QStuff("stuff");

    public final QCreateTime _super = new QCreateTime(this);

    public final BooleanPath delete = createBoolean("delete");

    public final StringPath description = createString("description");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstDateTime = _super.firstDateTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastDateTime = _super.lastDateTime;

    public final BooleanPath lock = createBoolean("lock");

    public final com.prjfoody.foody.domain.QUsers owner;

    public final StringPath title = createString("title");

    public QStuff(String variable) {
        this(Stuff.class, forVariable(variable), INITS);
    }

    public QStuff(Path<? extends Stuff> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStuff(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStuff(PathMetadata metadata, PathInits inits) {
        this(Stuff.class, metadata, inits);
    }

    public QStuff(Class<? extends Stuff> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.owner = inits.isInitialized("owner") ? new com.prjfoody.foody.domain.QUsers(forProperty("owner")) : null;
    }

}

