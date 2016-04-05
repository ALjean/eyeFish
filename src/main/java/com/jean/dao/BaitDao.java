package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.PondEnvirmoment;

public interface BaitDao {

    Bait getBait(int baitId) throws DaoDfmException, CustomDfmException;
    
    List<Bait> getBaitsToFishes(int fishId) throws DaoDfmException;
    
    List<Bait> getBaitsToFishesByDate(int fishId, Date date) throws DaoDfmException;
    
    List<Bait> getBaitsBySeason(Date date) throws DaoDfmException;
    
    List<Bait> getBaits(int baitid, String baitName, Date date, int fishId, PondEnvirmoment pondEnv) throws DaoDfmException, CustomDfmException;
    
    Integer saveBait(Bait bait) throws DaoDfmException, CustomDfmException;

    void deleteBait(int baitId) throws DaoDfmException, CustomDfmException;
    
    void updateBait(Bait bait) throws DaoDfmException, CustomDfmException;
    
   /* Message getMessage(String key) throws DaoDfmException;
    
    Message getMessage(int messageId);
    
    List<String> getMessages() throws DaoDfmException;
    
    Integer saveMessage(Message message);
    
    Integer updateMessage(Message mesage);
    
    void deleteMessage(int messageId);*/
 
}
