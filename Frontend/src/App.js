import React,{useState} from "react";
import axios from "axios";

function App() {
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData, 
      [name]: value, 
    });
  };
  const [formData, setFormData] = useState({ name: "", email: "", phone: "" });
  const handlesubmit=async(e)=>{e.preventDefault();
    try{
      const response=await axios.post("http://localhost:8080/api/users/register",formData);
      alert(response.data);
    }catch(error){
      console.error("Error submitting form",error);
    }
  };
  return (
    <div className="container">
      <div className="form-box">
      <h2>Sign In</h2>
      <form onSubmit={handlesubmit}>
        <input type="text" name="name" placeholder="Full Name" value={formData.name} onChange={handleInputChange} required/>
        <input type="email" name="email" placeholder="Email" value={formData.email} onChange={handleInputChange} required/>
        <input type="text" name="phone" placeholder="Phone Number" value={formData.phone} onChange={handleInputChange} required/>
        <div className="button-container">
        <button type="submit">Sign In</button></div>
      </form>
      </div>
    </div>
  );
}

export default App;
