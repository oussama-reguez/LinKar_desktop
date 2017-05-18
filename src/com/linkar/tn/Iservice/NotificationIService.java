/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.Iservice;

import com.linkar.tn.entities.Notification;
import java.util.List;

/**
 *
 * @author Oussama Reguez
 */
public interface NotificationIService {

     void addNotfication(String type, int id_membre, int id_sender);

    List<Notification> getAllNotification(int id_membre);

    List<Notification> getAllNotificationByType(int id_membre, String type);

     int countAllNotification(int id_membre);

    int countRecentNotification(int id_membre, String type, int lastCount);

   List<Notification> getRecentNotificaton(int id_membre, String type, int lastCount);

    List<Notification> MonitorNotification(int id_membre, String type, int lastCount);

    int countNotificatdfdionByType(int id_membre, String type);

}
