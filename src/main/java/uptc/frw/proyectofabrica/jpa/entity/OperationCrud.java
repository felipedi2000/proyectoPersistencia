package uptc.frw.proyectofabrica.jpa.entity;

import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Document;
import java.time.LocalDateTime;
import java.util.Date;

@Document(indexName = "operaciones_crud", createIndex = true)
public class OperationCrud {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String message;

    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private Date timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
