package com.coop.crud.dao.daofactory;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.coop.crud.dao.PriestDao;
import com.coop.crud.dao.PriestDaoImpl;
import com.coop.crud.dao.datasource.DataSource;
import com.coop.crud.modal.Priest;
import com.coop.crud.modal.codec.ModalCodec;
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
	
	public PriestDao<Priest> getTodoDao() {
		Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		ModalCodec<Priest> modalCodec = new ModalCodec<Priest>(defaultDocumentCodec, Priest.class); 
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
			    CodecRegistries.fromCodecs(modalCodec),
			    MongoClient.getDefaultCodecRegistry()
			);
		MongoCollection<Priest> coll = db.getCollection("todo", Priest.class).withWriteConcern(WriteConcern.ACKNOWLEDGED)
					.withCodecRegistry(codecRegistry);
		return new PriestDaoImpl<Priest>(coll);
	}
	
	public static void close(){
		DataSource.close();
	}
	
}
