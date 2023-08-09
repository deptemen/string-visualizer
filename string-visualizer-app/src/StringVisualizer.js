import React, { useState } from 'react';
import axios from 'axios';

const StringVisualizer = () => {
  const [inputString1, setInputString1] = useState('');
  const [inputString2, setInputString2] = useState('');
  const [result, setResult] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const handleSubmit = async () => {
    try {
      const response = await axios.post('http://localhost:8080/visualize-max-occurrence', {
        inputString1,
        inputString2,
      });

      setResult(response.data);
      setErrorMessage('');
    } catch (error) {
        if (error.response && error.response.status === 400) {
            setErrorMessage("Bad Request: Inputs should not be empty,Please provide valid inputs");
            setResult('');
            console.error("Bad Request: Invalid input data");
        } else {
          setErrorMessage("An error occurred while processing your request.");
            console.error('API error:', error);
        }
      console.error('API error:', error);
    }
  };

  return (
    <div>
      <h2>STRING VISUALIZER</h2>
      <div>
        <label><b>Input String 1: </b></label>
        <input
          type="text" required style={{ fontSize: '16pt', width: '60%' }}
          value={inputString1}
          onChange={(e) => setInputString1(e.target.value)}
        />
      </div>
      <br></br>
      <div>
        <label><b>Input String 2: </b></label>
        <input
          type="text" required style={{ fontSize: '16pt', width: '60%' }}
          value={inputString2}
          onChange={(e) => setInputString2(e.target.value)}
        />
      </div>
      <br></br>
      <button onClick={handleSubmit}>Visualize</button>
      <br></br>
      <br></br>
      <div>
        <label><b>Result: </b></label>
        {result}
      </div>
      <div style={{ color: 'red' }}>
        {errorMessage}
      </div>
    </div>
  );
};

export default StringVisualizer;
