package com.action;


import com.dao.*;
import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
public class MainController {

    @Autowired
    private ISubjectService ss;
    @Autowired
    private IItemService is;
    @Autowired
    private IOptionService os;

    //main页面展示题目信息
    @RequestMapping(value = "/allSubject",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HashMap<String,Object> allSubject(HttpSession session){
        HashMap<String,Object> mp = new HashMap();
        System.out.println("主页面进来了");
        User u = (User) session.getAttribute("userinfo");
        System.out.println("主页面session拿的用户："+u);
        List<Subject> list = ss.selectAll();
        mp.put("u",u);
        mp.put("list",list);
        return mp;
    }

    //main页面展示人数参数&题目选项
    @RequestMapping(value = "/count/{id}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public HashMap count(@PathVariable(value="id") Integer id){
        HashMap<String,Object> mp = new HashMap();
        int numSub= ss.selectCountOption(id);
        System.out.println("题目选项值："+numSub);
        int numUser=is.selectCountUser(id);
        System.out.println("参与人数："+numUser);
        mp.put("numSub",numSub);
        mp.put("numUser",numUser);
        return mp;
    }

    //新增
    @RequestMapping(value = "/addSubject",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public int addSubject(Subject sub,@RequestParam List<String> voOption){
        System.out.println("拿到的Subject对象是"+sub.toString());
        int num = ss.insert(sub);
        //初始化
        int i = 1;
        for (String s:voOption){
            Option op = new Option();
            System.out.println("拿到的voOption是"+s);
            op.setVoOption(s);
            op.setVoOrder(i);
            op.setVsId(sub.getVsId());
            os.insert(op);
            i++;
        }
        if(num>0){
            return 1;
        }else{
            return 0;
        }
    }


    //修改放入值
    @RequestMapping(value = "/updatePoll/{vsId}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public HashMap updatePoll(@PathVariable(value = "vsId") Integer vsId,HttpSession session){
        System.out.println("修改时ID进来："+vsId);
        session.setAttribute("vsId",vsId);
        HashMap<String,Object> mp = new HashMap();
        Subject sub = ss.selectByPrimaryKey(vsId);
        List<String> clist = new  ArrayList();
        List<Integer> vlist = new  ArrayList();
        List<Option> list = os.selectByVsId(vsId);
        for(Option st:list){
            System.out.println("第一个对应选项题目："+st.getVoOption());
            String option = st.getVoOption();
            int voId = st.getVoId();
            clist.add(option);
            vlist.add(voId);
        }
        mp.put("clist",clist);
        mp.put("list",list);
        mp.put("vlist",vlist);
        mp.put("sub",sub);
        return mp;
    }

    //放值后进行修改
    @RequestMapping(value = "/updataVote/{voId}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public int updataVote(@PathVariable(value = "voId") Integer voId,Subject sub,@RequestParam List<String> voOption,HttpSession session){
        int vsId = (int) session.getAttribute("vsId");
        System.out.println("修改拿到的Subject对象是"+sub.toString());
        System.out.println("voId值"+voId);
        sub.setVsId(vsId);
        int num = ss.updateByPrimaryKey(sub);
        int i = 1;
        for (String op:voOption){
            System.out.println("op选项值"+op);
            Option option = new Option();
            option.setVoId(voId);
            option.setVsId(vsId);
            option.setVoOrder(i);
            option.setVoOption(op);
            os.updateByPrimaryKey(option);
            i++;
            voId++;
        }
        if(num>0){
            return 0;
        }else{
            return 1;
        }

        //初始化

    }

    //投票
    @RequestMapping(value = "/poll/{vsId}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public HashMap poll(@PathVariable(value = "vsId") Integer vsId){
        System.out.println("投票时ID进来："+vsId);
        HashMap<String,Object> mp = new HashMap();
        List<Option> list = os.selectByVsId(vsId);
        Subject sub = ss.selectByPrimaryKey(vsId);
        int numSub= ss.selectCountOption(vsId);
        System.out.println("投票时题目选项值："+numSub);
        int numUser=is.selectCountUser(vsId);
        System.out.println("投票时参与人数："+numUser);
        int countVsid = is.selectCountAllVote(vsId);
        System.out.println("总的投票数："+countVsid);
        mp.put("sub",sub);
        mp.put("numSub",numSub);
        mp.put("numUser",numUser);
        mp.put("list",list);
        return mp;
    }
    //查看投票
    @RequestMapping(value = "/look/{vsId}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public HashMap look(@PathVariable(value = "vsId") Integer vsId,HttpSession session){
        session.setAttribute("vsId1",vsId);
        System.out.println("投票时ID进来："+vsId);
        HashMap<String,Object> mp = new HashMap();
        List<Integer> clist = new  ArrayList();
        List<Option> list = os.selectByVsId(vsId);
        for(Option st:list){
            System.out.println("第一个选项ID："+st.getVoId());
            System.out.println("第一个对应选项题目："+st.getVoOption());
            int countVoid = is.selectCountOneVote(st.getVoId());
            System.out.println("单选项的投票数："+countVoid);
            clist.add(countVoid);
        }
        int countVsid = is.selectCountAllVote(vsId);
        System.out.println("总的投票数："+countVsid);
        mp.put("countVsid",countVsid);
        mp.put("clist",clist);
        return mp;
    }

    //点击投票
    @RequestMapping(value = "/toupiao/{vsId}",produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public int toupiao(@PathVariable(value="vsId") Integer vsId,HttpSession session,@RequestParam List<Integer> voId){
        for (Integer s:voId) {
            Item it = new Item();
            System.out.println("投票时选项题目进来：" + s);
            it.setVoId(s);
            User u = (User) session.getAttribute("userinfo");
            System.out.println("投票时用户ID："+u.getVuUserId());
            it.setVuUserId(u.getVuUserId());
            it.setVsId(vsId);
            System.out.println("投票时题目ID进来"+vsId);
           int num =  is.insert(it);
            if(num>0){
                return 1;
            }else{
                return 0;
            }
        }
        return 1;
    }

}
