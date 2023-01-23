/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.takamaka.app.collecttkg.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author tyranneo
 */
@Data
@NoArgsConstructor
@Slf4j
@AllArgsConstructor
public class ChallengeResponseBean {

    private String difficulty;
    private int challengeId;
    private String challenge;
    
}
