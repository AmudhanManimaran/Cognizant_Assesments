import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails(props) {
    return (
        <div className={styles.box}>

            <h3
                style={{
                    color:
                        props.currentStatus === "Ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {props.cohortName}
            </h3>

            <dl>
                <dt>Started On</dt>
                <dd>{props.startedOn}</dd>

                <dt>Current Status</dt>
                <dd>{props.currentStatus}</dd>

                <dt>Coach</dt>
                <dd>{props.coach}</dd>

                <dt>Trainer</dt>
                <dd>{props.trainer}</dd>
            </dl>

        </div>
    );
}

export default CohortDetails;