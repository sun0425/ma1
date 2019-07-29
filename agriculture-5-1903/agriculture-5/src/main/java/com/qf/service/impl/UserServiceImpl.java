package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.UserDao;
import com.qf.domain.Admin;
import com.qf.domain.AgricultureUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lucifer on 2019.7.19.0019.
 */
@Service
public class UserServiceImpl implements UserService {
    /*@Autowired
    private UserRepository userRepository;





    @Override
    public QueryResponseResult findAll(Integer page, Integer size) {
        page = page - 1;
        if(page<=0){
            page = 0;
        }
        if(size<=0){
            size = 20;
        }

        Pageable pageable = PageRequest.of(page,size);
        Page<AgricultureUser> all = userRepository.findAll(pageable);
        List<AgricultureUser> content = all.getContent();
        Long total = all.getTotalElements();
        QueryResult<AgricultureUser> userQueryResult = new QueryResult<>();
        userQueryResult.setList(content);
        userQueryResult.setTotal(total);

        return new QueryResponseResult<>(CommonCode.SUCCESS,userQueryResult);
    }
*/

    @Autowired
    private UserDao userDao;

    @Override
    public List<AgricultureUser> loadAllUser(int pages, int rows) {
        PageHelper.startPage(pages,rows);

        return userDao.loadAllUser();
    }

    @Override
    public int countRows(int rows) {

        int i = userDao.countRows();
        return i%rows>0?i/rows+1:i/rows;
    }

    @Override
    public AgricultureUser loadUserById(Integer userId) {

        return userDao.loadUserById(userId);
    }

    @Override
    public int updateUser(AgricultureUser user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }



    @Override
    public int deleteBatch(List<Integer> uidList) {

        return userDao.deleteBatch(uidList);
    }


    @Override
    public int addUser(AgricultureUser user) {

        return userDao.addUser(user);
    }

/*

    @Override
    public int userAddRole(Map<String,Integer> map){
        return userDao.userAddRole(map);
    }

    @Override
    public int deleteUserRole(Map<String, Integer> map) {
        return userDao.deleteUserRole(map);
    }
      @Override
    public int deleteUserRole(int userId) {
        return userDao.deleteUserRole(userId);
    }
*/

}
