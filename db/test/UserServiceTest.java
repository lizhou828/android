import android.test.AndroidTestCase;
import android.util.Log;
import com.example.ORMLite.DatabaseHelper;
import com.example.model.User;
import com.example.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-9
 * Time: 下午1:13
 * To change this template use File | Settings | File Templates.
 */


public class UserServiceTest extends AndroidTestCase {
    public void datatest() throws Throwable{
        DatabaseHelper dbhepler=new DatabaseHelper(this.getContext());
        dbhepler.getReadableDatabase();
    }
    //注册
    public void registerTest() throws Throwable{
        UserService uService=new UserService(this.getContext());
        User user=new User();
        user.setUsername("renhaili");
        user.setPassword("123");
        user.setAge(20);
        user.setGender("女");
        uService.register(user);
    }
    public void loginTest() throws Throwable{
        UserService uService=new UserService(this.getContext());
        String username="renhaili";
        String password="123";
        boolean flag=uService.login(username, password);
        if(flag){
            Log.i("TAG", "登录成功");
        }else{
            Log.i("TAG","登录失败");
        }
    }

}
