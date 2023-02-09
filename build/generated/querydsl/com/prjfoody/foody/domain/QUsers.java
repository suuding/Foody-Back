package com.prjfoody.foody.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 1614154783L;

    public static final QUsers users = new QUsers("users");

    public final com.prjfoody.foody.domain.abstracts.QCreateTime _super = new com.prjfoody.foody.domain.abstracts.QCreateTime(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstDateTime = _super.firstDateTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastDateTime = _super.lastDateTime;

    public final StringPath name = createString("name");

    public final StringPath passwd = createString("passwd");

    public final StringPath tel = createString("tel");

    public final EnumPath<com.prjfoody.foody.domain.types.UserType> userType = createEnum("userType", com.prjfoody.foody.domain.types.UserType.class);

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

