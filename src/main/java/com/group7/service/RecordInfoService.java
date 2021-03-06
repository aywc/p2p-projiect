package com.group7.service;


import java.util.List;
import java.util.Map;

/**
 * ClassName:RecordInfoService
 * Description:
 * Author:严浩天
 * CreateTime:2018-12-08 16:45
 */
public interface RecordInfoService {
    /**
     * 资金记录列表
     * @return
     */
    List<Map> moneyRecordList(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int moneyRecordListCount(Map map);

    /**
     * 根据moneyrecord删除
     * @param moneyrecord
     * @return
     */
    int deleteMoneyRecord(int moneyrecord);

    /**
     * 根据名字查找id
     * @param userName
     * @return
     */
    int getId(String userName);

    /**
     * 根据userinformationid查找userid
     * @param userinformationid
     * @return
     */
    int getUserIdByUserinformationId(int userinformationid);

    /**
     * 查找用户的累计投资
     * @param userid
     * @return
     */
    Integer getSumInvestment(int userid);

    /**
     * 根据userinformationid查找累计收益
     * @param userinformationid
     * @return
     */
    Map getSumIncome(int userinformationid);

    /**
     * 投资记录列表
     * @return
     */
    List<Map> investList(Map map);

    /**
     * 投资记录列表分页总数量
     * @param map
     * @return
     */
    int investListCount(Map map);

    /**
     * 系统消息列表
     * @return
     */
    List<Map> systemMessageList(Map map);

    /**
     * 系统消息分页总数量
     * @param map
     * @return
     */
    int systemMessageListCount(Map map);

    /**
     * 根据moneyrecord删除
     * @param messageid
     * @return
     */
    int deleteMessageRecord(int messageid);

    /**
     * 将未读消息变为已读
     * @param map
     * @return
     */
    int changeMessageState(Map map);

    /**
     * 获取未读消息的数量
     * @return
     */
    int getUnreadCount(int userid);
    /**
     * 贷款记录
     * @param map
     * @return
     */
    List<Map> loansList(Map map);

    /**
     * 贷款记录计数
     * @param map
     * @return
     */
    int loansListCount(Map map);
}
