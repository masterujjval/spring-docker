import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button} from '@mui/material';

export default function Student() {
    const [name, setName] = React.useState("");
    const [address, setAddress] = React.useState("");
    const [students, setStudents] = React.useState([]);

    const handleClick = (event) => {
        event.preventDefault();
        const student = {name, address}
        console.log(student)
        fetch("http://localhost:8080/student/add", {
            method: "post",
            headers: {"content-type": "application/json"},
            body: JSON.stringify(student)
        }).then(() => {console.log("New Student Registered")})
    }

    React.useEffect(()=>{
        fetch("http://localhost:8080/student/getAll")
        .then(response => response.json())
        .then(result => setStudents(result));
    }, [])

    const paperStyle={padding: '50px 20px', width:600, margin:'20px auto'}

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
        <h1 style={{color:"purple"}}>Add Student</h1>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1 },
      }}
      noValidate
      autoComplete="off"
    >
      
      <TextField id="filled-basic" label="Student Name" variant="filled" fullWidth
      value={name}
      onChange={(event) => setName(event.target.value)}
      />
      <TextField id="filled-basic" label="Student Address" variant="filled" fullWidth
      value={address}
      onChange={(event) => setAddress(event.target.value)}/>
      <Button variant="contained" color='secondary' onClick={handleClick}>Submit</Button>
    </Box>
    </Paper>

    <h1>Student Details</h1>

    <Paper elevation={3} style={paperStyle}>

     {students.map((student) => (
         <Paper elevation={6} style={{ margin: "10px", padding: "15px", textAlign: "left" }} key={student.id}>
         <strong> Id:</strong> {student.id} <br/>
         <strong> Name:</strong> {student.name} <br/>
         <strong> Address:</strong> {student.address}
        </Paper>
      ))}

    </Paper>

    </Container>
  );
}
