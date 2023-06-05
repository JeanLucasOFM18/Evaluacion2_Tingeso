import "../styles/Home.css";

const Home = () =>{
    return <div className="hero">
        <div className="text-box">
            <h1>MilkStgo</h1>
            <h3>La mejor productora de lácteos de Chile</h3>
        </div>
        <div className="images">
            <img src="https://i.postimg.cc/Ss2MWdkd/imagen-2023-04-20-165925490-removebg-preview.png" className="shape" alt="Shape" />
            <img src="https://i.postimg.cc/y6DPPhvw/imagen-2023-04-20-165729700-removebg-preview-2.png" className="milk" alt="Milk" />
        </div>
    </div>;
   }
   
   export default Home;