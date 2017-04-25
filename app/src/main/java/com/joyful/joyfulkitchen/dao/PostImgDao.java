package com.joyful.joyfulkitchen.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.joyful.joyfulkitchen.model.Post;

import com.joyful.joyfulkitchen.model.PostImg;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "tb_post_img".
*/
public class PostImgDao extends AbstractDao<PostImg, Long> {

    public static final String TABLENAME = "tb_post_img";

    /**
     * Properties of entity PostImg.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property PostImgId = new Property(0, Long.class, "postImgId", true, "post_img_id");
        public final static Property ImgUrl = new Property(1, String.class, "imgUrl", false, "img_url");
        public final static Property PostId = new Property(2, Long.class, "postId", false, "post_id");
        public final static Property CreateTime = new Property(3, java.util.Date.class, "createTime", false, "create_time");
        public final static Property UpdateTime = new Property(4, java.util.Date.class, "updateTime", false, "update_time");
    }

    private DaoSession daoSession;

    private Query<PostImg> post_PostImgListQuery;

    public PostImgDao(DaoConfig config) {
        super(config);
    }
    
    public PostImgDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"tb_post_img\" (" + //
                "\"post_img_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: postImgId
                "\"img_url\" TEXT," + // 1: imgUrl
                "\"post_id\" INTEGER," + // 2: postId
                "\"create_time\" INTEGER," + // 3: createTime
                "\"update_time\" INTEGER);"); // 4: updateTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"tb_post_img\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PostImg entity) {
        stmt.clearBindings();
 
        Long postImgId = entity.getPostImgId();
        if (postImgId != null) {
            stmt.bindLong(1, postImgId);
        }
 
        String imgUrl = entity.getImgUrl();
        if (imgUrl != null) {
            stmt.bindString(2, imgUrl);
        }
 
        Long postId = entity.getPostId();
        if (postId != null) {
            stmt.bindLong(3, postId);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(4, createTime.getTime());
        }
 
        java.util.Date updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindLong(5, updateTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PostImg entity) {
        stmt.clearBindings();
 
        Long postImgId = entity.getPostImgId();
        if (postImgId != null) {
            stmt.bindLong(1, postImgId);
        }
 
        String imgUrl = entity.getImgUrl();
        if (imgUrl != null) {
            stmt.bindString(2, imgUrl);
        }
 
        Long postId = entity.getPostId();
        if (postId != null) {
            stmt.bindLong(3, postId);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(4, createTime.getTime());
        }
 
        java.util.Date updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindLong(5, updateTime.getTime());
        }
    }

    @Override
    protected final void attachEntity(PostImg entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PostImg readEntity(Cursor cursor, int offset) {
        PostImg entity = new PostImg( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // postImgId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // imgUrl
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // postId
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // createTime
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)) // updateTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PostImg entity, int offset) {
        entity.setPostImgId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setImgUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPostId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setCreateTime(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setUpdateTime(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PostImg entity, long rowId) {
        entity.setPostImgId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PostImg entity) {
        if(entity != null) {
            return entity.getPostImgId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PostImg entity) {
        return entity.getPostImgId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "postImgList" to-many relationship of Post. */
    public List<PostImg> _queryPost_PostImgList(Long postId) {
        synchronized (this) {
            if (post_PostImgListQuery == null) {
                QueryBuilder<PostImg> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.PostId.eq(null));
                post_PostImgListQuery = queryBuilder.build();
            }
        }
        Query<PostImg> query = post_PostImgListQuery.forCurrentThread();
        query.setParameter(0, postId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getPostDao().getAllColumns());
            builder.append(" FROM tb_post_img T");
            builder.append(" LEFT JOIN tb_post T0 ON T.\"post_id\"=T0.\"post_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected PostImg loadCurrentDeep(Cursor cursor, boolean lock) {
        PostImg entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Post post = loadCurrentOther(daoSession.getPostDao(), cursor, offset);
        entity.setPost(post);

        return entity;    
    }

    public PostImg loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<PostImg> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<PostImg> list = new ArrayList<PostImg>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<PostImg> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<PostImg> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
