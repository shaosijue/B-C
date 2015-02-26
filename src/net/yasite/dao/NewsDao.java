package net.yasite.dao;import java.util.List;import net.yasite.entity.NewsEntity;import android.database.Cursor;import android.database.sqlite.SQLiteDatabase;import android.database.sqlite.SQLiteStatement;import de.greenrobot.dao.AbstractDao;import de.greenrobot.dao.Property;import de.greenrobot.dao.internal.DaoConfig;public class NewsDao extends AbstractDao< NewsEntity , Long> {	public static final String TABLENAME = "NEWS";	public NewsDao(DaoConfig config) {		super(config);	}	public NewsDao(DaoConfig config, DaoSession daoSession) {		super(config, daoSession);	}	public static class Properties { 		public final static Property _id = new Property(0,Long.class,"_id",true,"_ID");		public final static Property Id = new Property(1,String.class,"id",false,"ID");		public final static Property Title = new Property(2,String.class,"title",false,"TITLE");		public final static Property Desc = new Property(3,String.class,"desc",false,"DESC");		public final static Property Pic = new Property(4,String.class,"pic",false,"PIC");	}	public static void createTable(SQLiteDatabase db, boolean ifNotExists) { 		String constraint = ifNotExists ? "IF NOT EXISTS " : "";		StringBuffer sql = new StringBuffer(0);		sql.append("CREATE TABLE " + constraint + "'" + TABLENAME + "' ( ")		.append("_ID INTEGER PRIMARY KEY ,")		.append("ID TEXT ,")		.append("TITLE TEXT ,")		.append("DESC TEXT ,")		.append("PIC TEXT );");		db.execSQL(sql.toString());	}	public static void dropTable(SQLiteDatabase db, boolean ifExists) {		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'" + TABLENAME + "'";		db.execSQL(sql);	}	@Override	protected void bindValues(SQLiteStatement stmt, NewsEntity entity) {		if(entity.get_id() != null){			stmt.bindLong(1, entity.get_id());		}		if(entity.getId() != null){			stmt.bindString(2, entity.getId());		}		if(entity.getTitle() != null){			stmt.bindString(3, entity.getTitle());		}		if(entity.getDesc() != null){			stmt.bindString(4, entity.getDesc());		}		if(entity.getPic() != null){			stmt.bindString(5, entity.getPic());		}	}	@Override	protected Long getKey(NewsEntity entity) {		if (entity != null) {			return entity.get_id();		} else {			return null;		}	}	@Override	protected boolean isEntityUpdateable() {		return true;	}	@Override	protected Long readKey(Cursor cursor, int offset) {		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);	}	@Override	protected Long updateKeyAfterInsert(NewsEntity entity, long rowId) {		entity.set_id(rowId);		return rowId;	}	private NewsEntity setEntity(Cursor cursor, NewsEntity entity, int offset){		entity.set_id(cursor.getLong(offset + 0));		entity.setId(cursor.getString(offset + 1));		entity.setTitle(cursor.getString(offset + 2));		entity.setDesc(cursor.getString(offset + 3));		entity.setPic(cursor.getString(offset + 4));		return entity;	}	@Override	protected NewsEntity readEntity(Cursor cursor, int offset) {		NewsEntity entity = new NewsEntity();		return setEntity(cursor,entity,offset);	}	@Override	protected void readEntity(Cursor cursor, NewsEntity entity, int offset) {		entity = setEntity(cursor,entity,offset);	}		public List<NewsEntity> getAllList(){		return queryBuilder().list();	}	public NewsEntity getListInfo(String title){		List<NewsEntity> list = queryBuilder().where(Properties.Title.eq(title)).list();		if(list.size() > 0){			return list.get(0);		}else{			return null;		}	}}