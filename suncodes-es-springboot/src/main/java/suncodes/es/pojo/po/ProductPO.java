package suncodes.es.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "shopping", shards = 3, replicas = 1)
public class ProductPO {
    // 必须有 id,这里的 id 是全局唯一的标识，等同于 es 中的"_id"
    /** 商品唯一标识 */
    @Id
    private Long id;
    /**
     * type : 字段数据类型
     * analyzer : 分词器类型
     * index : 是否索引(默认:true)
     * Keyword : 短语,不进行分词
     */
    /** 商品名称 */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    /** 分类名称 */
    @Field(type = FieldType.Keyword)
    private String category;
    /** 商品价格 */
    @Field(type = FieldType.Double)
    private Double price;
    /** 图片地址 */
    @Field(type = FieldType.Keyword, index = false)
    private String images;
}
