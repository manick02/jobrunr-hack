package org.example.atl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateVoteTest {

    @Test
    public void getCandidateVoteInstance() {
        CandidateVote candidate = new CandidateVote();
        assertNotNull(candidate);
    }

    @Test
    public void getCandidateWinner() {
        List<CandidateVote.Vote> votes = new ArrayList<>();
        votes.add(new CandidateVote.Vote("C1"));
        votes.add(new CandidateVote.Vote("C2"));
        votes.add(new CandidateVote.Vote("C2"));
        votes.add(new CandidateVote.Vote("C2"));
        CandidateVote.Commission commission  = new CandidateVote.Commission(votes);
        String winner = commission.getWinner();
        Assertions.assertEquals("C2",winner);
    }


}