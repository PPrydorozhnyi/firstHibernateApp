package generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by drake on 22/03/18.
 *
 * @author P.Pridorozhny
 */
public class CustomIdGenerator implements IdentifierGenerator {

    private String DEFAULT_SEQUENCE_NAME = "custom_seq";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Serializable result = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = sharedSessionContractImplementor.connection();
            statement = connection.createStatement();

                resultSet = statement.executeQuery("SELECT "+DEFAULT_SEQUENCE_NAME+".NEXTVAL FROM DUAL");

            if(resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println("Custom generated Sequence value : "+result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
