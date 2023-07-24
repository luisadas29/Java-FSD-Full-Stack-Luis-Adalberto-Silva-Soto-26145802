import React, { useEffect, useState } from "react";
import axios from "axios";

function OnlineTest() {
  const [questions, setQuestions] = useState([]);
  const [answers, setAnswers] = useState([]);
  const [score, setScore] = useState(0);
  const [showSummary, setShowSummary] = useState(false);

  useEffect(() => {
    axios
      .get("http://localhost:3000/questions")
      .then((result) => {
        setQuestions(result.data);
      })
      .catch((error) => {
        console.log(error);
      });

    axios
      .get("http://localhost:3000/answers")
      .then((result) => {
        setAnswers(result.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const [selectedAnswers, setSelectedAnswers] = useState(new Map());

  const handleAnswerSelection = (event, qid, ans) => {
    setSelectedAnswers((prevSelectedAnswers) => {
      const updatedSelectedAnswers = new Map(prevSelectedAnswers);
      updatedSelectedAnswers.set(qid, ans);
      return updatedSelectedAnswers;
    });
  };

  const handleSubmit = () => {
    let userScore = 0;

    selectedAnswers.forEach((selectedAnswer, qid) => {
      const correctAnswer = answers.find((answer) => answer.qid === qid)?.correctAns;
      if (String(selectedAnswer) === String(correctAnswer)) {
        userScore++;
      }
    });

    setScore(userScore);
    setShowSummary(true);
  };

  const handleRetakeExam = () => {
    setSelectedAnswers(new Map());
    setScore(0);
    setShowSummary(false);
  };

  const questionItems = questions.map((question) => (
    <div key={question.qid}>
      <h4>{question.qid}) {question.question} ?</h4>
      <ul>
        {question.options.map((option) => (
          <li key={option}>
            <label>
              <input
                type="radio"
                name={question.qid}
                value={option}
                checked={selectedAnswers.get(question.qid) === option}
                onChange={(event) => handleAnswerSelection(event, question.qid, option)}
              />
              {option}
            </label>
          </li>
        ))}
      </ul>
    </div>
  ));

  const summaryItems = questions.map((question) => {
    const selectedAnswer = selectedAnswers.get(question.qid);
    const correctAnswer = answers.find((answer) => answer.qid === question.qid)?.correctAns;
    const isCorrect = String(selectedAnswer) === String(correctAnswer);

    return (
      <div key={question.qid}>
        <h4>{question.qid}) {question.question}</h4>
        <p>Your Answer: {selectedAnswer}</p>
        {isCorrect ? (
          <p style={{ color: "green" }}>Correct!</p>
        ) : (
          <>
            <p style={{ color: "red" }}>Incorrect!</p>
            <p>Correct Answer: {correctAnswer}</p>
          </>
        )}
        <hr />
      </div>
    );
  });

  return (
    <div>
      <h2>Online Test</h2>
      {!showSummary ? (
        <>
          {questionItems}
          <button onClick={handleSubmit} style={{ fontSize: "18px", padding: "10px 20px" }}>
  Submit
</button>

        </>
      ) : (
        <>
          <h3>Review</h3>
          {summaryItems}
          <p>Score: {score}</p>
          <button onClick={handleRetakeExam}>Retake Exam</button>
        </>
      )}
    </div>
  );
}

export default OnlineTest;

