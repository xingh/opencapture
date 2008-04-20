/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.filterlogic.OpenCapture.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author D106931
 */
@Entity
@Table(name = "lkp_batchclass_queues")
@NamedQueries({@NamedQuery(name = "LkpBatchclassQueues.findByQueueId", query = "SELECT l FROM LkpBatchclassQueues l WHERE l.lkpBatchclassQueuesPK.queueId = :queueId"), @NamedQuery(name = "LkpBatchclassQueues.findByBatchClassId", query = "SELECT l FROM LkpBatchclassQueues l WHERE l.lkpBatchclassQueuesPK.batchClassId = :batchClassId"), @NamedQuery(name = "LkpBatchclassQueues.findBySequenceId", query = "SELECT l FROM LkpBatchclassQueues l WHERE l.sequenceId = :sequenceId")})
public class LkpBatchclassQueues implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LkpBatchclassQueuesPK lkpBatchclassQueuesPK;
    @Column(name = "SEQUENCE_ID", nullable = false)
    private int sequenceId;

    public LkpBatchclassQueues() {
    }

    public LkpBatchclassQueues(LkpBatchclassQueuesPK lkpBatchclassQueuesPK) {
        this.lkpBatchclassQueuesPK = lkpBatchclassQueuesPK;
    }

    public LkpBatchclassQueues(LkpBatchclassQueuesPK lkpBatchclassQueuesPK, int sequenceId) {
        this.lkpBatchclassQueuesPK = lkpBatchclassQueuesPK;
        this.sequenceId = sequenceId;
    }

    public LkpBatchclassQueues(long queueId, long batchClassId) {
        this.lkpBatchclassQueuesPK = new LkpBatchclassQueuesPK(queueId, batchClassId);
    }

    public LkpBatchclassQueuesPK getLkpBatchclassQueuesPK() {
        return lkpBatchclassQueuesPK;
    }

    public void setLkpBatchclassQueuesPK(LkpBatchclassQueuesPK lkpBatchclassQueuesPK) {
        this.lkpBatchclassQueuesPK = lkpBatchclassQueuesPK;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lkpBatchclassQueuesPK != null ? lkpBatchclassQueuesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LkpBatchclassQueues)) {
            return false;
        }
        LkpBatchclassQueues other = (LkpBatchclassQueues) object;
        if ((this.lkpBatchclassQueuesPK == null && other.lkpBatchclassQueuesPK != null) || (this.lkpBatchclassQueuesPK != null && !this.lkpBatchclassQueuesPK.equals(other.lkpBatchclassQueuesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.filterlogic.OpenCapture.data.LkpBatchclassQueues[lkpBatchclassQueuesPK=" + lkpBatchclassQueuesPK + "]";
    }

}
