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

import com.joyful.joyfulkitchen.model.User;

import com.joyful.joyfulkitchen.model.Post;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "tb_post".
*/
public class PostDao extends AbstractDao<Post, Long> {

    public static final String TABLENAME = "tb_post";

    /**
     * Properties of entity Post.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property PostId = new Property(0, Long.class, "postId", true, "post_id");
        public final static Property Message = new Property(1, String.class, "message", false, "MESSAGE");
        public final static Property Browse = new Property(2, int.class, "browse", false, "BROWSE");
        public final static Property Comments = new Property(3, int.class, "comments", false, "COMMENTS");
        public final static Property Praise = new Property(4, int.class, "praise", false, "PRAISE");
        public final static Property UserId = new Property(5, Long.class, "userId", false, "user_id");
        public final static Property CreateTime = new Property(6, java.util.Date.class, "createTime", false, "create_time");
        public final static Property UpdateTime = new Property(7, java.util.Date.class, "updateTime", false, "update_time");
    }

    private DaoSession daoSession;


    public PostDao(DaoConfig config) {
        super(config);
    }
    
    public PostDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"tb_post\" (" + //
                "\"post_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: postId
                "\"MESSAGE\" TEXT," + // 1: message
                "\"BROWSE\" INTEGER NOT NULL ," + // 2: browse
                "\"COMMENTS\" INTEGER NOT NULL ," + // 3: comments
                "\"PRAISE\" INTEGER NOT NULL ," + // 4: praise
                "\"user_id\" INTEGER," + // 5: userId
                "\"create_time\" INTEGER," + // 6: createTime
                "\"update_time\" INTEGER);"); // 7: updateTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"tb_post\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Post entity) {
        stmt.clearBindings();
 
        Long postId = entity.getPostId();
        if (postId != null) {
            stmt.bindLong(1, postId);
        }
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(2, message);
        }
        stmt.bindLong(3, entity.getBrowse());
        stmt.bindLong(4, entity.getComments());
        stmt.bindLong(5, entity.getPraise());
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(6, userId);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(7, createTime.getTime());
        }
 
        java.util.Date updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindLong(8, updateTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Post entity) {
        stmt.clearBindings();
 
        Long postId = entity.getPostId();
        if (postId != null) {
            stmt.bindLong(1, postId);
        }
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(2, message);
        }
        stmt.bindLong(3, entity.getBrowse());
        stmt.bindLong(4, entity.getComments());
        stmt.bindLong(5, entity.getPraise());
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(6, userId);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(7, createTime.getTime());
        }
 
        java.util.Date updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindLong(8, updateTime.getTime());
        }
    }

    @Override
    protected final void attachEntity(Post entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Post readEntity(Cursor cursor, int offset) {
        Post entity = new Post( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // postId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // message
            cursor.getInt(offset + 2), // browse
            cursor.getInt(offset + 3), // comments
            cursor.getInt(offset + 4), // praise
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // userId
            cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)), // createTime
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)) // updateTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Post entity, int offset) {
        entity.setPostId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMessage(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBrowse(cursor.getInt(offset + 2));
        entity.setComments(cursor.getInt(offset + 3));
        entity.setPraise(cursor.getInt(offset + 4));
        entity.setUserId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setCreateTime(cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)));
        entity.setUpdateTime(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Post entity, long rowId) {
        entity.setPostId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Post entity) {
        if(entity != null) {
            return entity.getPostId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Post entity) {
        return entity.getPostId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM tb_post T");
            builder.append(" LEFT JOIN tb_user T0 ON T.\"user_id\"=T0.\"user_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Post loadCurrentDeep(Cursor cursor, boolean lock) {
        Post entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
        entity.setUser(user);

        return entity;    
    }

    public Post loadDeep(Long key) {
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
    public List<Post> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Post> list = new ArrayList<Post>(count);
        
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
    
    protected List<Post> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Post> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
