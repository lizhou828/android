package com.example.service;

import com.example.pojo.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-4
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public class ContactService {
    public List<Contact> getContacts(){
        List<Contact>  contactList = new ArrayList<Contact>();
        contactList.add(new Contact(1,"小明","1234","13600000000"));
        contactList.add(new Contact(2,"小花","34","13211111111"));
        contactList.add(new Contact(3,"小丽","234234","13433333333"));
        contactList.add(new Contact(4,"小菜","1230234","13455555555"));
        return contactList;
    }

}
