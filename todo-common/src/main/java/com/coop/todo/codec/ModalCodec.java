package com.coop.todo.codec;

import java.util.UUID;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;

public class ModalCodec<T> implements CollectibleCodec<T>{
	private Codec<Document> documentCodec;
	private static Gson gson = new GsonBuilder().create();
	private Class<T> t;
	
	public ModalCodec() {}
	
	public ModalCodec(Class<T> t) {
		if(this.documentCodec == null) {
			this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		}
		this.t = t;
	}
	
	public ModalCodec(Codec<Document> documentCodec, Class<T> t) {
		this.documentCodec = documentCodec;
		this.t =  t;
	}
	
	public void encode(BsonWriter writer, T t, EncoderContext context) {
		Document document = new Document();
		document = Document.parse(gson.toJson(t));
	    documentCodec.encode(writer, document, context);
	}

	public Class<T> getEncoderClass() {
		return this.t;
	}

	public T decode(BsonReader reader, DecoderContext context) {
		T todo;
		try {
			todo = this.t.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = documentCodec.decode(reader, context);
		todo = gson.fromJson(document.toJson(), this.t);
		return todo;
	}

	public boolean documentHasId(T t) {
		boolean flag = false;
		try {
			flag = t.getClass().getField("id").get(t) != null;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public T generateIdIfAbsentFromDocument(T t) {
		if (!documentHasId(t))
		    {
		    try {
				this.t.getField("id").set(t, UUID.randomUUID().toString());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		return t;
	}

	public BsonValue getDocumentId(T t) {
		if(!documentHasId(t)) {
			throw new IllegalStateException("The document does not contain an _id");
		}
		BsonValue bValue = null;
		try {
			bValue = new BsonString(this.t.getField("id").get(t).toString());
		} catch (IllegalArgumentException e) {
			// TODO throw exception
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bValue;
	}

}

