package com.coop.todo.daofactory;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.coop.todo.codec.ModalCodec;
import com.coop.todo.dao.TodoDao;
import com.coop.todo.dao.TodoDaoImpl;
import com.coop.todo.datasource.DataSource;
import com.coop.todo.modal.Todo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DaoFactory {
	
	private static MongoDatabase db = DataSource.getDBInstance();
	
	private static DaoFactory daoFactory = null;
	
	public static DaoFactory instance() {
		if(null == daoFactory) {
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}
	
	public TodoDao<Todo> getTodoDao() {
		Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		ModalCodec<Todo> modalCodec = new ModalCodec<Todo>(defaultDocumentCodec, Todo.class); 
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
			    CodecRegistries.fromCodecs(modalCodec),
			    MongoClient.getDefaultCodecRegistry()
			);
		MongoCollection<Todo> coll = db.getCollection("todo", Todo.class).withWriteConcern(WriteConcern.ACKNOWLEDGED)
					.withCodecRegistry(codecRegistry);
		return new TodoDaoImpl<Todo>(coll);
	}
	
	public static void close(){
		DataSource.close();
	}
	
}
