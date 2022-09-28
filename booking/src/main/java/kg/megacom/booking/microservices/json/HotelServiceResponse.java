package kg.megacom.booking.microservices.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelServiceResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String stars;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String address;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String phone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String city;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String imgUrl;


}
